<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>

        *{
            margin:0;
            padding:0;
        }

        ul,ol{
            list-style:none
        }

        body{
            height:100vh;
            background:#000000;
            display:flex;
            justify-content:center;
            align-items:center;
        }

        ul{
            height:200px;
            display:flex
        }
        li{
            width:15px;
            height:15px;
            border-radius:10px;
            background:#ff0000;
            margin-right:15px;
        }

        li:nth-child(1){
            background: #ff0000;
            animation: love1 4s 0s infinite;
        }
        li:nth-child(2) {
            background: #ff6a00;
            animation: love2 4s 0.2s infinite;
        }
        li:nth-child(3) {
            background: #ffd800;
            animation: love3 4s 0.4s infinite;
        }
        li:nth-child(4) {
            background: #4cff00;
            animation: love4 4s 0.6s infinite;
        }
        li:nth-child(5) {
            background: #00ffff;
            animation: love5 4s 0.8s infinite;
        }
        li:nth-child(6) {
            background: #0026ff;
            animation: love4 4s 1s infinite;
        }
        li:nth-child(7) {
            background: #b200ff;
            animation: love3 4s 1.2s infinite;
        }
        li:nth-child(8) {
            background: #ff00dc;
            animation: love2 4s 1.4s infinite;
        }
        li:nth-child(9) {
            background: #ff0000;
            animation: love1 4s 1.6s infinite;
        }



        @keyframes love1{
            30%, 50%{
                height:60px;
                transform:translateY(-30px);
            }
            70%, 100%{
                height:0px;
                transform:translateY(0px);
            }
        }

        @keyframes love2 {
            30%,50% {
                height: 125px;
                transform: translateY(-60px);
            }

            70%,100% {
                height: 0px;
                transform: translateY(0px);
            }
        }

        @keyframes love3 {
            30%,50% {
                height: 160px;
                transform: translateY(-75px);
            }

            70%,100% {
                height: 0px;
                transform: translateY(0px);
            }
        }

        @keyframes love4 {
            30%,50% {
                height: 180px;
                transform: translateY(-60px);
            }

            70%,100% {
                height: 0px;
                transform: translateY(0px);
            }
        }

        @keyframes love5 {
            30%,50% {
                height: 200px;
                transform: translateY(-40px);
            }

            70%,100% {
                height: 0px;
                transform: translateY(0px);
            }
        }

        @-webkit-keyframes shake {
            0% {
                opacity: 0.8;
            }

            50% {
                opacity: 0.2;
            }

            100% {
                opacity: 0.8;
            }
        }

        @keyframes shake {
            0% {
                opacity: 0.8;
            }
            50% {
                opacity: 0.2;
            }

            100% {
                opacity: 0.8;
            }
        }

        .shake {
            font-size: 50px;
            color: #ff0000;
            width: 350px;
            height: 50px;
            right: 800px;
            top: 200px;
            -webkit-animation: shake 2.5s infinite;
            animation: shake 2.5s infinite;
        }



    </style>
</head>
<body>


<ul class="shake">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
</ul>

</body>
</html>