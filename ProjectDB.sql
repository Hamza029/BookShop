create table Book(
	bID int,
	bName varchar(255),
	author varchar(255) not null,
	category varchar(255) not null,
	buyingPrice int not null,
	sellingPrice int not null,
	copies int not null,
	constraint Book_PK primary key (bID)
)

create table Sales(
	saleID int identity(1,1),
	saleDate date not null,
	username varchar(255),
	profit int not null,
	price int not null,
	saleInfo text,
	constraint Sale_PK primary key (saleID)
)

create table Employee(
	eID int,
	username varchar(255) not null,
	pass varchar(255) not null,
	eRole varchar(255) not null,
	eName varchar(255) not null,
	ePhone varchar(255) not null,
	salary int not null,
	constraint Emp_Uique unique (username),
	constraint Emp_PK primary key (eID)
)

create table Seller(
	seID int identity(1000,1),
	eID int foreign key references Employee (eID),
	constraint Seller_PK primary key (seID)
)

create table Dealer(
	deID int identity(1000,1),
	eID int foreign key references Employee (eID),
	constraint Dealer_PK primary key (deID)
)

create table Admin(
	username varchar(255),
	pass varchar(255)
	constraint Admin_PK primary key (username)
)

create table Deals(
	dealID int identity(1,1),
	dealDate date,
	username varchar(255),
	dealInfo text
)

select Employee.eID
from Seller
inner join Employee on Seller.eID = Employee.eID

select * from Book
select * from Sales
select * from Employee
select * from Seller
select * from Dealer
select * from deals
select * from Admin

select eID,Employee.username,pass,eRole,eName,ePhone,salary,COUNT(Sales.username) as 'tot_sales',COUNT(Deals.username) as 'tot_deals'
from Employee
left join Sales
on Employee.username = Sales.username
left join Deals
on Employee.username = Deals.username
group by Employee.username,Employee.eID,pass,eRole,eName,ePhone,salary
having eRole = 'Seller'


select Employee.username, Employee.eName, Sales.saleID, Sales.saleDate, Sales.price, Sales.profit, Sales.saleInfo
from Employee
right join Sales
on Employee.username = Sales.username

select COUNT(eID) from Employee
select count(saleID) as tot_sales from Sales