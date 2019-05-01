<!doctype html>
<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="<@spring.url '/static/assets/img/favicon.ico' />">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Sample Admin CRUD</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <link href="<@spring.url '/static/assets/css/bootstrap.min.css' />" rel="stylesheet" />
    <link href="<@spring.url '/static/assets/css/animate.min.css' />" rel="stylesheet"/>
    <link href="<@spring.url '/static/assets/css/light-bootstrap-dashboard.css?v=1.4.0' />" rel="stylesheet"/>
    <link href="<@spring.url '/static/assets/css/demo.css' />" rel="stylesheet" />
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="<@spring.url '/static/assets/css/pe-icon-7-stroke.css' />" rel="stylesheet" />
    <script src="<@spring.url '/static/assets/js/jquery.3.2.1.min.js' />" type="text/javascript"></script>
    <script src="<@spring.url '/static/assets/js/bootstrap.min.js' />" type="text/javascript"></script>
    <script src="<@spring.url '/static/assets/js/jquery.twbsPagination.js' />"></script>
</head>
<body>

<div class="wrapper">
    <#setting number_format="computer">
    <#include "/fragments/sidebar.ftl">
    <div class="main-panel">
        <#include "/fragments/header.ftl">
        <#include CONTENT>
        <#include "/fragments/footer.ftl">
    </div>
</div>


</body>
<script src="<@spring.url '/static/assets/js/chartist.min.js' />"></script>
<script src="<@spring.url '/static/assets/js/bootstrap-notify.js' />"></script>
<script src="<@spring.url '/static/assets/js/light-bootstrap-dashboard.js?v=1.4.0' />"></script>

</html>
