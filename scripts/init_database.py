import os
import sqlalchemy
from sqlalchemy import create_engine, Table, Column, Integer, String, ForeignKey
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column, relationship

from typing import List
from typing import Optional

class Base(DeclarativeBase):
    pass

class User(Base):
    __tablename__ = "user_account"
    id: Mapped[int] = mapped_column(primary_key=True)
    name: Mapped[str] = mapped_column(String(30))
    fullname: Mapped[Optional[str]]
    addresses: Mapped[List["Address"]] = relationship(back_populates="user")
    def __repr__(self) -> str:
        return f"User(id={self.id!r}, name={self.name!r}, fullname={self.fullname!r})"

class Address(Base):
    __tablename__ = "address"
    id: Mapped[int] = mapped_column(primary_key=True)
    email_address: Mapped[str]
    user_id = mapped_column(ForeignKey("user_account.id"))
    user: Mapped[User] = relationship(back_populates="addresses")
    def __repr__(self) -> str:
        return f"Address(id={self.id!r}, email_address={self.email_address!r})"

if __name__ == '__main__':
    print("sqlalchemy version:", sqlalchemy.__version__)
    print("Criação de Banco de Dados iniciada.")

    DATABASE_URI = os.getenv("DATABASE_URI")

    engine = create_engine(DATABASE_URI, echo=True)

    Base.metadata.create_all(engine)