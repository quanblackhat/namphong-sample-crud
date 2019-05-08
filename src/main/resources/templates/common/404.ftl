<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Trang không tồn tại</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }

        h1 {
            font-size: 50px;
            margin-bottom: 6px;
        }
    </style>
</head>
<body>
<h1> Trang bạn tìm kiếm không tồn tại </h1>
<p> <a href="<@spring.url '/'/>"> Đi đến trang chủ </a> </p>
</body>
</html>