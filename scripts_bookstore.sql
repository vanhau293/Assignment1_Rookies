USE [bookstore]
GO
/****** Object:  Table [dbo].[author]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[author](
	[author_id] [int] IDENTITY(1,1) NOT NULL,
	[author_name] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_author] PRIMARY KEY CLUSTERED 
(
	[author_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[book]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[book](
	[book_id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](100) NOT NULL,
	[author_id] [int] NOT NULL,
	[category_id] [int] NOT NULL,
	[puslisher] [nvarchar](100) NULL,
	[quantity] [int] NULL,
	[price] [bigint] NOT NULL,
	[total_page] [int] NOT NULL,
	[description] [nvarchar](max) NOT NULL,
	[image] [image] NOT NULL,
	[average_rating] [float] NULL,
 CONSTRAINT [PK_book] PRIMARY KEY CLUSTERED 
(
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_book] UNIQUE NONCLUSTERED 
(
	[title] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[cart]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cart](
	[customer_id] [int] NOT NULL,
	[book_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
 CONSTRAINT [PK_cart] PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC,
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[category]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_category] PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_category] UNIQUE NONCLUSTERED 
(
	[category_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[customer]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[customer](
	[customer_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[address] [nvarchar](200) NULL,
	[phone_number] [char](10) NOT NULL,
	[email] [varchar](100) NULL,
	[username] [varchar](50) NULL,
 CONSTRAINT [PK_customer] PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_customer] UNIQUE NONCLUSTERED 
(
	[phone_number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_customer_username] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[employee]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[employee](
	[employee_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[gender] [nchar](3) NULL,
	[address] [nvarchar](200) NULL,
	[phone_number] [char](10) NOT NULL,
	[email] [varchar](100) NULL,
	[username] [varchar](50) NULL,
 CONSTRAINT [PK_employee] PRIMARY KEY CLUSTERED 
(
	[employee_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_employee] UNIQUE NONCLUSTERED 
(
	[phone_number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UK_employee_username] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[goods_received]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[goods_received](
	[received_id] [int] IDENTITY(1,1) NOT NULL,
	[created_date] [datetime] NOT NULL,
	[total_cash] [bigint] NOT NULL,
	[employee_id] [int] NOT NULL,
 CONSTRAINT [PK_goods_received] PRIMARY KEY CLUSTERED 
(
	[received_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[order]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[created_date] [datetime] NOT NULL,
	[total_cash] [bigint] NOT NULL,
	[confirmed] [bit] NOT NULL,
	[employee_id] [int] NULL,
	[customer_id] [int] NOT NULL,
 CONSTRAINT [PK_order] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[order_detail]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_detail](
	[order_id] [int] NOT NULL,
	[book_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[unit_price] [bigint] NOT NULL,
 CONSTRAINT [PK_order_detail] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC,
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[rating]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[rating](
	[customer_id] [int] NOT NULL,
	[book_id] [int] NOT NULL,
	[comment] [nvarchar](max) NULL,
	[star_rating] [int] NOT NULL,
 CONSTRAINT [PK_rating] PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC,
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[received_detail]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[received_detail](
	[received_id] [int] NOT NULL,
	[book_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[unit_price] [bigint] NOT NULL,
 CONSTRAINT [PK_received_detail] PRIMARY KEY CLUSTERED 
(
	[received_id] ASC,
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[role]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [nvarchar](50) NULL,
 CONSTRAINT [PK_role] PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[user]    Script Date: 17-Jun-22 00:32:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[role_id] [int] NOT NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[book] ADD  CONSTRAINT [DF_book_quantity]  DEFAULT ((0)) FOR [quantity]
GO
ALTER TABLE [dbo].[book] ADD  CONSTRAINT [DF_book_ave_rating]  DEFAULT ((0)) FOR [average_rating]
GO
ALTER TABLE [dbo].[employee] ADD  CONSTRAINT [DF_employee_gender]  DEFAULT (N'Nam') FOR [gender]
GO
ALTER TABLE [dbo].[order] ADD  CONSTRAINT [DF_order_total_cash]  DEFAULT ((0)) FOR [total_cash]
GO
ALTER TABLE [dbo].[order] ADD  CONSTRAINT [DF_order_confirmed]  DEFAULT ((0)) FOR [confirmed]
GO
ALTER TABLE [dbo].[book]  WITH CHECK ADD  CONSTRAINT [FK_book_author] FOREIGN KEY([author_id])
REFERENCES [dbo].[author] ([author_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[book] CHECK CONSTRAINT [FK_book_author]
GO
ALTER TABLE [dbo].[book]  WITH CHECK ADD  CONSTRAINT [FK_book_category] FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([category_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[book] CHECK CONSTRAINT [FK_book_category]
GO
ALTER TABLE [dbo].[cart]  WITH CHECK ADD  CONSTRAINT [FK_cart_book] FOREIGN KEY([book_id])
REFERENCES [dbo].[book] ([book_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[cart] CHECK CONSTRAINT [FK_cart_book]
GO
ALTER TABLE [dbo].[cart]  WITH CHECK ADD  CONSTRAINT [FK_cart_customer] FOREIGN KEY([customer_id])
REFERENCES [dbo].[customer] ([customer_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[cart] CHECK CONSTRAINT [FK_cart_customer]
GO
ALTER TABLE [dbo].[customer]  WITH CHECK ADD  CONSTRAINT [FK_customer_user] FOREIGN KEY([username])
REFERENCES [dbo].[user] ([username])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[customer] CHECK CONSTRAINT [FK_customer_user]
GO
ALTER TABLE [dbo].[employee]  WITH CHECK ADD  CONSTRAINT [FK_employee_user] FOREIGN KEY([username])
REFERENCES [dbo].[user] ([username])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[employee] CHECK CONSTRAINT [FK_employee_user]
GO
ALTER TABLE [dbo].[goods_received]  WITH CHECK ADD  CONSTRAINT [FK_goods_received_employee] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employee] ([employee_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[goods_received] CHECK CONSTRAINT [FK_goods_received_employee]
GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD  CONSTRAINT [FK_order_customer] FOREIGN KEY([customer_id])
REFERENCES [dbo].[customer] ([customer_id])
GO
ALTER TABLE [dbo].[order] CHECK CONSTRAINT [FK_order_customer]
GO
ALTER TABLE [dbo].[order]  WITH CHECK ADD  CONSTRAINT [FK_order_employee] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employee] ([employee_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[order] CHECK CONSTRAINT [FK_order_employee]
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD  CONSTRAINT [FK_order_detail_book] FOREIGN KEY([book_id])
REFERENCES [dbo].[book] ([book_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[order_detail] CHECK CONSTRAINT [FK_order_detail_book]
GO
ALTER TABLE [dbo].[order_detail]  WITH CHECK ADD  CONSTRAINT [FK_order_detail_order] FOREIGN KEY([order_id])
REFERENCES [dbo].[order] ([order_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[order_detail] CHECK CONSTRAINT [FK_order_detail_order]
GO
ALTER TABLE [dbo].[rating]  WITH CHECK ADD  CONSTRAINT [FK_rating_book] FOREIGN KEY([book_id])
REFERENCES [dbo].[book] ([book_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[rating] CHECK CONSTRAINT [FK_rating_book]
GO
ALTER TABLE [dbo].[rating]  WITH CHECK ADD  CONSTRAINT [FK_rating_customer] FOREIGN KEY([customer_id])
REFERENCES [dbo].[customer] ([customer_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[rating] CHECK CONSTRAINT [FK_rating_customer]
GO
ALTER TABLE [dbo].[received_detail]  WITH CHECK ADD  CONSTRAINT [FK_received_detail_book] FOREIGN KEY([book_id])
REFERENCES [dbo].[book] ([book_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[received_detail] CHECK CONSTRAINT [FK_received_detail_book]
GO
ALTER TABLE [dbo].[received_detail]  WITH CHECK ADD  CONSTRAINT [FK_received_detail_goods_received] FOREIGN KEY([received_id])
REFERENCES [dbo].[goods_received] ([received_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[received_detail] CHECK CONSTRAINT [FK_received_detail_goods_received]
GO
ALTER TABLE [dbo].[user]  WITH CHECK ADD  CONSTRAINT [FK_user_role] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([role_id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[user] CHECK CONSTRAINT [FK_user_role]
GO
ALTER TABLE [dbo].[rating]  WITH CHECK ADD  CONSTRAINT [CK_star_rating] CHECK  (([star_rating]>=(1) AND [star_rating]<=(5)))
GO
ALTER TABLE [dbo].[rating] CHECK CONSTRAINT [CK_star_rating]
GO
