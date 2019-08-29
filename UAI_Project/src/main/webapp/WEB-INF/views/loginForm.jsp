<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MainPage</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        
        <!-- Bootstrap CSS -->
       <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   
        <!-- Include jQuery library and Flexslider script -->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/flexslider/2.6.3/jquery.flexslider-min.js"></script>
      <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
      
        <!-- font 설정 -->
        <link rel="stylesheet" href="https://use.typekit.net/kcj1cyn.css">

        <style type="text/css">
        #wrapper{
            width: 1024px;
            margin: 0px auto;
        }
            #top-box{
                width: 1024px;
                height: 200px;
                float: left;
            }
                #top-small-box1{
                    width: 440px;
                    height: 200px;
                    float: left;
                }
                #logo-login-form{
                    width: 100px;
                    height: 100px;
                    float: left;
                    margin-top: 100px;
                    
                }

            #middle-box{
                width: 1024px;
                height: 400px;
                float: left;
                font-family: lemongrass-caps, sans-serif;
                font-weight: 400;
                font-style: normal;
                
            }
                #member-login-all{
                    float: left;
                    margin-left:50px;
                }
                #member-login{
                    width: 400px;
                    height: 350px;
                    float: left;
                    margin-left: 30px;
                    margin-right: 10px;
                    font-size: 8pt;
                }
                #member-login-title{
                    font-size: 20px;
                    margin-left: 50px;
                    margin-bottom:5px;
                }
                #member-login-btn{
                    float: right;
                    margin-right: 10px;
                }
                .form-control{
                    font-size: 10pt;        
                    font-family: trilby, serif;
                }

                #admin-login-all{
                    float: left;
                    margin-left:50px;
                }
                #admin-login{
                    width: 400px;
                    height: 350px;
                    float: left;
                    margin-left: 50px;
                    margin-right: 10px;
                    font-size: 8pt;
                }
                #admin-login-title{
                    font-size: 20px;
                    margin-left: 70px;
                    margin-bottom:5px;
                }
                #admin-login-btn{
                    float: right;
                    margin-right: -95px;
                }
                
                
                #center-line{
                    width: 3px;
                    height: 150px;
                    float: left;
                    margin-top: 10px;
                    float: left;
                }

        

        </style>
        
    </head>

    <body>
        <div class="container-fluid" id="wrapper">
           
            <div id="top-box">
                <div id="top-small-box1"></div>
                <a href="./mainPage"><img  id="logo-login-form" src="./img/logo.png"></a>
            </div> <!--top div-->
            
            <div id="middle-box">
                
                <div id="member-login-all">
                    <div id="member-login-title">
                                Member  Login<br>
                    </div>

                    <div id="member-login">
                        <form class="form-horizontal" action="./memberLoginAction" method="post">
                            <div class="form-group">
                            <div class="col-sm-9">
                                <input type="text" class="form-control" placeholder="Member ID" name="m_id">
                            </div>
                            <br>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" placeholder="Password" name="m_pw">
                            </div><br>
                            <div class="col-sm-offset-2 col-sm-9" id="member-login-btn">
                               <button class="btn btn-link"><a href="./joinMemberForm">Join With</a></button>
                                <button type="submit" class="btn btn-info">Sign in</button>
                            </div>
                            </div>
                        </form>
                           
                    </div><!--member login-->
                </div> <!--member login all-->
                    
                <img id="center-line" src="./img/loginBoxLine.png">
                
                <div id="admin-login-all">
                    <div id="admin-login-title">
                                Administrator  Login<br>
                    </div>

                    <div id="admin-login">
                        <form class="form-horizontal" action="./adminLoginAction" method="post">
                            <div class="form-group">
                            <div class="col-sm-9">
                                <input type="text" class="form-control" placeholder="Admin ID" name="ad_id">
                            </div>
                            <br>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" placeholder="Password" name="ad_pw">
                            </div><br>
                            <div class="col-sm-offset-2 col-sm-9" id="admin-login-btn">
                                <button type="submit" class="btn btn-info">Sign in</button>
                            </div>
                            </div>
                        </form>
                    </div><!--admin login-->
                </div> <!--admin login all-->
            
            </div> <!--middle div-->
            
        </div><!--wrapper div-->
    </body>
</html>