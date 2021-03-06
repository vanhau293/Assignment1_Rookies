USE [bookstore]
GO
/****** Object:  Table [dbo].[accounts]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[accounts](
	[account_id] [int] IDENTITY(1,1) NOT NULL,
	[user_name] [varchar](50) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[role_id] [int] NOT NULL,
	[blocked] [bit] NOT NULL,
 CONSTRAINT [PK_accounts] PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[authors]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[authors](
	[author_id] [int] IDENTITY(1,1) NOT NULL,
	[author_name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[author_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[books]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[books](
	[book_id] [int] IDENTITY(1,1) NOT NULL,
	[avg_rating] [float] NULL,
	[description] [nvarchar](max) NULL,
	[image] [varchar](max) NULL,
	[price] [bigint] NOT NULL,
	[publisher] [nvarchar](255) NULL,
	[book_title] [nvarchar](255) NOT NULL,
	[total_page] [int] NOT NULL,
	[author_id] [int] NOT NULL,
	[category_id] [int] NOT NULL,
	[in_stock] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[book_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[cart]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cart](
	[book_id] [int] NOT NULL,
	[customer_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[book_id] ASC,
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[categories]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categories](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[category_name] [nvarchar](100) NOT NULL,
	[deleted] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[customers]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[customers](
	[customer_id] [int] IDENTITY(1,1) NOT NULL,
	[address] [nvarchar](255) NULL,
	[email] [varchar](255) NULL,
	[name] [nvarchar](255) NOT NULL,
	[phone_number] [char](10) NOT NULL,
	[account_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[employees]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[employees](
	[employee_id] [int] IDENTITY(1,1) NOT NULL,
	[address] [nvarchar](255) NULL,
	[email] [varchar](255) NULL,
	[gender] [nvarchar](3) NULL,
	[name] [nvarchar](255) NOT NULL,
	[phone_number] [char](10) NOT NULL,
	[account_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[employee_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[order_details]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_details](
	[book_id] [int] NOT NULL,
	[order_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[unit_price] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[book_id] ASC,
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[orders]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[update_date] [datetime] NOT NULL,
	[total_cash] [bigint] NOT NULL,
	[customer_id] [int] NOT NULL,
	[employee_id] [int] NULL,
	[status_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[reviews]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reviews](
	[book_id] [int] NOT NULL,
	[customer_id] [int] NOT NULL,
	[comment] [nvarchar](max) NULL,
	[star_rating] [int] NOT NULL,
	[created_date] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[book_id] ASC,
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[roles]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[roles](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[status]    Script Date: 01-Jul-22 16:53:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status](
	[status_id] [int] IDENTITY(1,1) NOT NULL,
	[status_name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[status_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[accounts] ON 

INSERT [dbo].[accounts] ([account_id], [user_name], [password], [role_id], [blocked]) VALUES (1, N'ADMIN', N'$2a$10$k1r1piTQ5ShrrFMlARPBdOMOe96TTwul6jRcfMG0b7ODCUUzzRhX.', 1, 0)
INSERT [dbo].[accounts] ([account_id], [user_name], [password], [role_id], [blocked]) VALUES (2, N'admin2', N'$2a$10$A5o3YSdNhJgZvN4VEZ6ZfuXWs/7UCo3X7/JwZOKHsYI4clZ8t6gme', 1, 0)
INSERT [dbo].[accounts] ([account_id], [user_name], [password], [role_id], [blocked]) VALUES (3, N'cvanhau', N'$2a$10$sHEH.24f9TxBPvQBAwf2D.fgeBp9t1ILMpYYBD2/STvcJapGXPzI.', 2, 0)
SET IDENTITY_INSERT [dbo].[accounts] OFF
SET IDENTITY_INSERT [dbo].[authors] ON 

INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (1, N'Abraham Silberschatz Professor')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (2, N'Carol S. Dweck')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (3, N'Đặng Hoàng Giang')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (19, N'Dương Thuỵ')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (5, N'Erin Niimi Longhurst')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (4, N'Gabriel Garcia Marquez')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (6, N'Hai Mươi')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (7, N'hihihi')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (8, N'Mario Puzo')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (10, N'Nam Cao')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (9, N'Nguyễn Du')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (11, N'Nguyễn Ngọc Tư')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (12, N'Nguyễn Nhật Ánh')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (13, N'Robin Sharma')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (14, N'Tô Hoài')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (15, N'Vũ Trọng Phụng')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (16, N'Wagner James Au')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (17, N'Yoshua Bengio')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (1019, N'Yoshua BengioOÔ')
INSERT [dbo].[authors] ([author_id], [author_name]) VALUES (18, N'Yuval Noah Harari')
SET IDENTITY_INSERT [dbo].[authors] OFF
SET IDENTITY_INSERT [dbo].[books] ON 

INSERT [dbo].[books] ([book_id], [avg_rating], [description], [image], [price], [publisher], [book_title], [total_page], [author_id], [category_id], [in_stock]) VALUES (1, 0, N'huuuuu', NULL, 114100, N'Nhã Nam', N'Trăm năm cô đơn', 293, 10, 10, 1)
INSERT [dbo].[books] ([book_id], [avg_rating], [description], [image], [price], [publisher], [book_title], [total_page], [author_id], [category_id], [in_stock]) VALUES (2, NULL, N'hhuhuhu', NULL, 63650, N'Thái Hà', N'3 người thầy vĩ đại', 330, 15, 5, 1)
SET IDENTITY_INSERT [dbo].[books] OFF
SET IDENTITY_INSERT [dbo].[categories] ON 

INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (1, N'Truyện kiếm hiệp', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (2, N'Truyện cười', 1)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (3, N'Sách kinh tế', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (4, N'Sách thiếu nhi', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (5, N'Sách kỹ năng sống', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (6, N'Sách giáo khoa', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (7, N'Truyện ngắn', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (8, N'Tiểu thuyết', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (9, N'Truyện kinh dị', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (10, N'Tản văn', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (11, N'Sách công nghệ thông tin', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (12, N'Sách lịch sử', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (13, N'Sách chính trị - pháp lý', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (14, N'Sách tâm lý', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (16, N'Tiểu sử - hồi ký', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (17, N'Thơ', 0)
INSERT [dbo].[categories] ([category_id], [category_name], [deleted]) VALUES (18, N'Truyện không vui', 1)
SET IDENTITY_INSERT [dbo].[categories] OFF
SET IDENTITY_INSERT [dbo].[customers] ON 

INSERT [dbo].[customers] ([customer_id], [address], [email], [name], [phone_number], [account_id]) VALUES (3, N'Thủ Đức', NULL, N'Châu Văn Hậu', N'0928337465', 3)
SET IDENTITY_INSERT [dbo].[customers] OFF
INSERT [dbo].[order_details] ([book_id], [order_id], [quantity], [unit_price]) VALUES (1, 1, 2, 114100)
INSERT [dbo].[order_details] ([book_id], [order_id], [quantity], [unit_price]) VALUES (1, 9, 2, 114100)
INSERT [dbo].[order_details] ([book_id], [order_id], [quantity], [unit_price]) VALUES (1, 10, 2, 114100)
INSERT [dbo].[order_details] ([book_id], [order_id], [quantity], [unit_price]) VALUES (1, 11, 2, 114100)
INSERT [dbo].[order_details] ([book_id], [order_id], [quantity], [unit_price]) VALUES (1, 12, 2, 114100)
SET IDENTITY_INSERT [dbo].[orders] ON 

INSERT [dbo].[orders] ([order_id], [update_date], [total_cash], [customer_id], [employee_id], [status_id]) VALUES (1, CAST(N'2022-06-20 12:25:32.020' AS DateTime), 228400, 3, NULL, 1)
INSERT [dbo].[orders] ([order_id], [update_date], [total_cash], [customer_id], [employee_id], [status_id]) VALUES (9, CAST(N'2022-06-28 12:25:32.020' AS DateTime), 228400, 3, NULL, 1)
INSERT [dbo].[orders] ([order_id], [update_date], [total_cash], [customer_id], [employee_id], [status_id]) VALUES (10, CAST(N'2022-06-28 12:25:32.230' AS DateTime), 228400, 3, NULL, 1)
INSERT [dbo].[orders] ([order_id], [update_date], [total_cash], [customer_id], [employee_id], [status_id]) VALUES (11, CAST(N'2022-06-28 12:25:32.020' AS DateTime), 228400, 3, NULL, 2)
INSERT [dbo].[orders] ([order_id], [update_date], [total_cash], [customer_id], [employee_id], [status_id]) VALUES (12, CAST(N'2022-06-28 12:25:32.020' AS DateTime), 228400, 3, NULL, 2)
SET IDENTITY_INSERT [dbo].[orders] OFF
SET IDENTITY_INSERT [dbo].[roles] ON 

INSERT [dbo].[roles] ([role_id], [role_name]) VALUES (1, N'ADMIN')
INSERT [dbo].[roles] ([role_id], [role_name]) VALUES (2, N'Customer')
SET IDENTITY_INSERT [dbo].[roles] OFF
SET IDENTITY_INSERT [dbo].[status] ON 

INSERT [dbo].[status] ([status_id], [status_name]) VALUES (1, N'Chờ xác nhận')
INSERT [dbo].[status] ([status_id], [status_name]) VALUES (2, N'Đã huỷ')
INSERT [dbo].[status] ([status_id], [status_name]) VALUES (3, N'Đã xác nhận')
SET IDENTITY_INSERT [dbo].[status] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK_accounts]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[accounts] ADD  CONSTRAINT [UK_accounts] UNIQUE NONCLUSTERED 
(
	[user_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK6u7v06wrrqeppb5k5abl0kqva]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[accounts] ADD  CONSTRAINT [UK6u7v06wrrqeppb5k5abl0kqva] UNIQUE NONCLUSTERED 
(
	[user_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK_authors]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[authors] ADD  CONSTRAINT [UK_authors] UNIQUE NONCLUSTERED 
(
	[author_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UKsd5ari86eauurkj7suf6h05xt]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[authors] ADD  CONSTRAINT [UKsd5ari86eauurkj7suf6h05xt] UNIQUE NONCLUSTERED 
(
	[author_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK_books]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[books] ADD  CONSTRAINT [UK_books] UNIQUE NONCLUSTERED 
(
	[book_title] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UKaunewltnfo4w371mjnbxjl307]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[books] ADD  CONSTRAINT [UKaunewltnfo4w371mjnbxjl307] UNIQUE NONCLUSTERED 
(
	[book_title] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK_categories]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[categories] ADD  CONSTRAINT [UK_categories] UNIQUE NONCLUSTERED 
(
	[category_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK41g4n0emuvcm3qyf1f6cn43c0]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[categories] ADD  CONSTRAINT [UK41g4n0emuvcm3qyf1f6cn43c0] UNIQUE NONCLUSTERED 
(
	[category_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UK_customers]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[customers] ADD  CONSTRAINT [UK_customers] UNIQUE NONCLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UK4njtl3pvfduamug24b9qmpy0x]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[customers] ADD  CONSTRAINT [UK4njtl3pvfduamug24b9qmpy0x] UNIQUE NONCLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK6v6x92wb400iwh6unf5rwiim4]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[customers] ADD  CONSTRAINT [UK6v6x92wb400iwh6unf5rwiim4] UNIQUE NONCLUSTERED 
(
	[phone_number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UK_employees]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[employees] ADD  CONSTRAINT [UK_employees] UNIQUE NONCLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UKguw5r3c5brob94evptgkjl9hr]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[employees] ADD  CONSTRAINT [UKguw5r3c5brob94evptgkjl9hr] UNIQUE NONCLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UKikty98aye7nunxe4f25a39efl]    Script Date: 01-Jul-22 16:53:57 ******/
ALTER TABLE [dbo].[status] ADD  CONSTRAINT [UKikty98aye7nunxe4f25a39efl] UNIQUE NONCLUSTERED 
(
	[status_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[accounts] ADD  CONSTRAINT [DF_accounts_blocked]  DEFAULT ((0)) FOR [blocked]
GO
ALTER TABLE [dbo].[books] ADD  CONSTRAINT [DF_books_average_rating]  DEFAULT ((0)) FOR [avg_rating]
GO
ALTER TABLE [dbo].[books] ADD  CONSTRAINT [DF_books_instock]  DEFAULT ((1)) FOR [in_stock]
GO
ALTER TABLE [dbo].[categories] ADD  CONSTRAINT [DF_categories_deleted]  DEFAULT ((0)) FOR [deleted]
GO
ALTER TABLE [dbo].[employees] ADD  CONSTRAINT [DF_employees_gender]  DEFAULT (N'Nam') FOR [gender]
GO
ALTER TABLE [dbo].[orders] ADD  CONSTRAINT [DF_orders_total_cash]  DEFAULT ((0)) FOR [total_cash]
GO
ALTER TABLE [dbo].[accounts]  WITH CHECK ADD  CONSTRAINT [FKt3wava8ssfdspnh3hg4col3m1] FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([role_id])
GO
ALTER TABLE [dbo].[accounts] CHECK CONSTRAINT [FKt3wava8ssfdspnh3hg4col3m1]
GO
ALTER TABLE [dbo].[books]  WITH CHECK ADD  CONSTRAINT [FKfjixh2vym2cvfj3ufxj91jem7] FOREIGN KEY([author_id])
REFERENCES [dbo].[authors] ([author_id])
GO
ALTER TABLE [dbo].[books] CHECK CONSTRAINT [FKfjixh2vym2cvfj3ufxj91jem7]
GO
ALTER TABLE [dbo].[books]  WITH CHECK ADD  CONSTRAINT [FKleqa3hhc0uhfvurq6mil47xk0] FOREIGN KEY([category_id])
REFERENCES [dbo].[categories] ([category_id])
GO
ALTER TABLE [dbo].[books] CHECK CONSTRAINT [FKleqa3hhc0uhfvurq6mil47xk0]
GO
ALTER TABLE [dbo].[cart]  WITH CHECK ADD  CONSTRAINT [FK1ykovbj90wkvqwa6m6463h21p] FOREIGN KEY([book_id])
REFERENCES [dbo].[books] ([book_id])
GO
ALTER TABLE [dbo].[cart] CHECK CONSTRAINT [FK1ykovbj90wkvqwa6m6463h21p]
GO
ALTER TABLE [dbo].[cart]  WITH CHECK ADD  CONSTRAINT [FKioh3c0mo0al2kswtnk5r09y7f] FOREIGN KEY([customer_id])
REFERENCES [dbo].[customers] ([customer_id])
GO
ALTER TABLE [dbo].[cart] CHECK CONSTRAINT [FKioh3c0mo0al2kswtnk5r09y7f]
GO
ALTER TABLE [dbo].[customers]  WITH CHECK ADD  CONSTRAINT [FKor0fx9fttvasr4grtaqnltyrl] FOREIGN KEY([account_id])
REFERENCES [dbo].[accounts] ([account_id])
GO
ALTER TABLE [dbo].[customers] CHECK CONSTRAINT [FKor0fx9fttvasr4grtaqnltyrl]
GO
ALTER TABLE [dbo].[employees]  WITH CHECK ADD  CONSTRAINT [FK8dwhb0qmor08fl06pde1bef3c] FOREIGN KEY([account_id])
REFERENCES [dbo].[accounts] ([account_id])
GO
ALTER TABLE [dbo].[employees] CHECK CONSTRAINT [FK8dwhb0qmor08fl06pde1bef3c]
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD  CONSTRAINT [FKjqe04yonp6a52rhbf2y0m03qw] FOREIGN KEY([book_id])
REFERENCES [dbo].[books] ([book_id])
GO
ALTER TABLE [dbo].[order_details] CHECK CONSTRAINT [FKjqe04yonp6a52rhbf2y0m03qw]
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD  CONSTRAINT [FKjyu2qbqt8gnvno9oe9j2s2ldk] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([order_id])
GO
ALTER TABLE [dbo].[order_details] CHECK CONSTRAINT [FKjyu2qbqt8gnvno9oe9j2s2ldk]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FKfhl8bv0xn3sj33q2f3scf1bq6] FOREIGN KEY([employee_id])
REFERENCES [dbo].[employees] ([employee_id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FKfhl8bv0xn3sj33q2f3scf1bq6]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FKnoettwqr56yaai4i8nwxg4huo] FOREIGN KEY([status_id])
REFERENCES [dbo].[status] ([status_id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FKnoettwqr56yaai4i8nwxg4huo]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FKpxtb8awmi0dk6smoh2vp1litg] FOREIGN KEY([customer_id])
REFERENCES [dbo].[customers] ([customer_id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FKpxtb8awmi0dk6smoh2vp1litg]
GO
ALTER TABLE [dbo].[reviews]  WITH CHECK ADD  CONSTRAINT [FK4sm0k8kw740iyuex3vwwv1etu] FOREIGN KEY([customer_id])
REFERENCES [dbo].[customers] ([customer_id])
GO
ALTER TABLE [dbo].[reviews] CHECK CONSTRAINT [FK4sm0k8kw740iyuex3vwwv1etu]
GO
ALTER TABLE [dbo].[reviews]  WITH CHECK ADD  CONSTRAINT [FK6a9k6xvev80se5rreqvuqr7f9] FOREIGN KEY([book_id])
REFERENCES [dbo].[books] ([book_id])
GO
ALTER TABLE [dbo].[reviews] CHECK CONSTRAINT [FK6a9k6xvev80se5rreqvuqr7f9]
GO
ALTER TABLE [dbo].[reviews]  WITH CHECK ADD  CONSTRAINT [CK_star_rating] CHECK  (([star_rating]>=(1) AND [star_rating]<=(5)))
GO
ALTER TABLE [dbo].[reviews] CHECK CONSTRAINT [CK_star_rating]
GO
