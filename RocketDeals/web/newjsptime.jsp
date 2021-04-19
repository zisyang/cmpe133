<%-- 
    Document   : newjsptime
    Created on : May 1, 2012, 11:15:47 PM
    Author     : BECoS
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/rocketdeals.css">
<script type="text/javascript">
function countdown() {

var currentDate = new Date(); // Today's Date

var targetDate = new Date(); // Date we are counting down to
targetDate.setMonth(<%=request.getSession().getAttribute("expMonth")%>,<%=request.getSession().getAttribute("expDay")%>); // (from 0-11; month), (from 1-31; date)
targetDate.setFullYear(<%=request.getSession().getAttribute("expYear")%>);
targetDate.setHours(0);
targetDate.setMinutes(0);
targetDate.setSeconds(0);
targetDate.setMilliseconds(0);

var msec = targetDate.getTime() - currentDate.getTime(); // The time left in milliseconds
var sec = Math.floor(msec / 1000);
var mins = Math.floor(sec / 60);
var hours = Math.floor(mins / 60);
var days = Math.floor(hours / 24);
sec = sec % 60;
mins = mins % 60;
hours = hours % 24;

/* Add Leading Zeros to Hours, Min, Sec */
if (sec < 10) {
    sec = '0'+sec;
}
if (mins < 10) {
    mins = '0'+mins;
}
if (hours < 10) {
    hours = '0'+hours;
}

document.getElementById('countdown').innerHTML = days+':'+hours+':'+mins+':'+sec;
var t = setTimeout('countdown();',1000);
}
</script>    
</head>
<body onload="countdown();">

<div class="count" align="center">
<strong id="countdown">Enable Javascript to see a Countdown to 2010!</strong>
<em id="label">days&nbsp;&nbsp;&nbsp;&nbsp; hours&nbsp;&nbsp;&nbsp; min&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; sec</em>
</div>
</body>
</html>

<%--<style>
<!--
strong#countdown {
    position: absolute;
    text-align: right;
    top: 25px;
    right: 50px;
    color: #CC0000;
    font-size: 24px;
}
em#label {
    position: absolute;
    text-align: right;
    top: 50px;
    right: 56px;
    color: #996600;
    font-size: 10px;
}
div.count {
    position: relative;
    left: -390px;
}
-->
</style>--%>