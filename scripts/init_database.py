import os
import sqlalchemy
from sqlalchemy import create_engine, ForeignKey
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column
from datetime import datetime

class Base(DeclarativeBase):
    pass

class Pessoa(Base):
    __tablename__ = "pessoa"
    id: Mapped[int] = mapped_column(primary_key=True)
    nome: Mapped[str] = mapped_column(nullable=False)
    cpf: Mapped[str] = mapped_column(nullable=False)

class Client(Base):
    __tablename__ = "client"
    id: Mapped[int] = mapped_column(primary_key=True)
    fator_risco: Mapped[str] = mapped_column(nullable=False)
    renda_mensal: Mapped[float] = mapped_column(nullable=False)
    pessoa_id: Mapped[int] = mapped_column(ForeignKey("pessoa.id"), nullable=False)

class TipoConta(Base):
    __tablename__ = "tipo_conta"
    id: Mapped[int] = mapped_column(primary_key=True)
    descricao: Mapped[str] = mapped_column(nullable=False)

class Conta(Base):
    __tablename__ = "conta"
    id: Mapped[int] = mapped_column(primary_key=True)
    saldo: Mapped[float] = mapped_column(nullable=False)
    limite_negativo: Mapped[float] = mapped_column(nullable=False)
    pessoa_id: Mapped[int] = mapped_column(ForeignKey("pessoa.id"), nullable=False)
    tipo_conta_id: Mapped[int] = mapped_column(ForeignKey("tipo_conta.id"), nullable=False)

class Reserva(Base):
    __tablename__ = "reserva"
    id: Mapped[int] = mapped_column(primary_key=True)
    saldo: Mapped[float] = mapped_column(nullable=False)
    taxa: Mapped[float] = mapped_column(nullable=False)
    reservacol: Mapped[str] = mapped_column(nullable=False)
    conta_id: Mapped[int] = mapped_column(ForeignKey("conta.id"), nullable=False)

class MovimentacaoReserva(Base):
    __tablename__ = "movimentacao_reserva"
    id: Mapped[int] = mapped_column(primary_key=True)
    dt_movimentacao: Mapped[datetime] = mapped_column(nullable=False)
    valor: Mapped[float] = mapped_column(nullable=False)
    reserva_id: Mapped[int] = mapped_column(ForeignKey("reserva.id"), nullable=False)

class CategoriaCartao(Base):
    __tablename__ = "categoria_cartao"
    id: Mapped[int] = mapped_column(primary_key=True)
    descricao: Mapped[str] = mapped_column(nullable=True)

class CartaoCredito(Base):
    __tablename__ = "cartao_credito"
    id: Mapped[int] = mapped_column(primary_key=True)
    dt_fechamento: Mapped[int] = mapped_column(nullable=True)
    conta_id: Mapped[int] = mapped_column(ForeignKey("conta.id"), nullable=False)
    categoria_cartao_id: Mapped[int] = mapped_column(ForeignKey("categoria_cartao.id"), nullable=False)

class BandeiraCartao(Base):
    __tablename__ = "bandeira_cartao"
    id: Mapped[int] = mapped_column(primary_key=True)
    descricao: Mapped[str] = mapped_column(nullable=True)

class CartaoTransacao(Base):
    __tablename__ = "cartao_transacao"
    id: Mapped[int] = mapped_column(primary_key=True)
    numero_cartao: Mapped[str] = mapped_column(nullable=False)
    cvc: Mapped[str] = mapped_column(nullable=False)
    cartao_id: Mapped[int] = mapped_column(ForeignKey("cartao.id"), nullable=False)
    tipo_conta: Mapped[int] = mapped_column(ForeignKey("tipo_conta.id"), nullable=False)
    nome_cartao: Mapped[str] = mapped_column(nullable=False)
    tipo_transacao: Mapped[str] = mapped_column(nullable=False)
    is_internacional: Mapped[bool] = mapped_column(nullable=False)
    bandeira_cartao_id: Mapped[int] = mapped_column(ForeignKey("bandeira_cartao.id"), nullable=False)

class MovimentacaoCartao(Base):
    __tablename__ = "movimentacao_cartao"
    id: Mapped[int] = mapped_column(primary_key=True)
    dt_movimentacao: Mapped[datetime] = mapped_column(nullable=False)
    valor: Mapped[float] = mapped_column(nullable=False)
    cartao_transacao_id: Mapped[int] = mapped_column(ForeignKey("cartao_transacao.id"), nullable=False)
    tipo_movimentacao: Mapped[str] = mapped_column(nullable=False)

class Corretor(Base):
    __tablename__ = "corretor"
    id: Mapped[int] = mapped_column(primary_key=True)
    nome: Mapped[datetime] = mapped_column(nullable=False)

class Compra(Base):
    __tablename__ = "compra"
    id: Mapped[int] = mapped_column(primary_key=True)
    valor: Mapped[float] = mapped_column(nullable=False)
    quantidade_parcela: Mapped[int] = mapped_column(nullable=False)
    taxa_parcelamento: Mapped[float] = mapped_column(nullable=False)
    credor: Mapped[str] = mapped_column(nullable=False)
    corretor_id: Mapped[int] = mapped_column(ForeignKey("corretor.id"), nullable=False)
    cartao_transacao_id: Mapped[int] = mapped_column(ForeignKey("cartao_transacao.id"), nullable=False)
    dt_compra: Mapped[datetime] = mapped_column(nullable=False)

class FaturaCartao(Base):
    __tablename__ = "fatura_cartao"
    id: Mapped[int] = mapped_column(primary_key=True)
    mes_referencia: Mapped[str] = mapped_column(nullable=False)
    ano_referencia: Mapped[str] = mapped_column(nullable=False)
    valor: Mapped[float] = mapped_column(nullable=False)
    dt_pagamento: Mapped[datetime] = mapped_column(nullable=False)
    cartao_credito_id: Mapped[int] = mapped_column(ForeignKey("cartao_credito.id"), nullable=False)

class ItensFatura(Base):
    __tablename__ = "itens_fatura"
    id: Mapped[int] = mapped_column(primary_key=True)
    descricao: Mapped[str] = mapped_column(nullable=False),
    fatura_cartao_id: Mapped[int] = mapped_column(ForeignKey("fatura_cartao.id"), nullable=False)

class TipoBoletoCustomizado(Base):
    __tablename__ = "tipo_boleto_customizado"
    id: Mapped[int] = mapped_column(primary_key=True)
    descricao: Mapped[str] = mapped_column(nullable=False)

class BoletoCustomizado:
    __tablename__ = "boleto_customizado"
    id: Mapped[int] = mapped_column(primary_key=True)
    valor: Mapped[float] = mapped_column(nullable=False)
    dt_vencimento: Mapped[datetime] = mapped_column(nullable=False)
    dt_geracao: Mapped[datetime] = mapped_column(nullable=False)
    codigo_barras: Mapped[str] = mapped_column(nullable=False)
    tipo_boleto_customizado_id: Mapped[int] = mapped_column(ForeignKey("tipo_boleto_customizado.id"), nullable=False)
    fatura_cartao_id: Mapped[int] = mapped_column(ForeignKey("fatura_cartao.id"), nullable=False)

class Pagamento:
    __tablename__ = "pagamento"
    id: Mapped[int] = mapped_column(primary_key=True)
    valor_total: Mapped[float] = mapped_column(nullable=False)
    dt_pagamento: Mapped[datetime] = mapped_column(nullable=False)
    valor_parcial: Mapped[datetime] = mapped_column(nullable=False)
    fatura_cartao_id: Mapped[int] = mapped_column(ForeignKey("fatura_cartao.id"), nullable=False)
    boleto_customizado_id: Mapped[int] = mapped_column(ForeignKey("boleto_customizado.id"), nullable=False)

if __name__ == '__main__':
    print("sqlalchemy version:", sqlalchemy.__version__)

    user = os.getenv("USER")
    password = os.getenv("PASSWORD")
    db = os.getenv("DB")
    host = os.getenv("HOST")
    port = os.getenv("PORT")

    uri = f"postgresql://{user}:{password}@{host}:{port}/{db}"

    engine = create_engine(uri, echo=True)

    print("Criação de Banco de Dados iniciada.")
    Base.metadata.create_all(engine)