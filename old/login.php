<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">




<meta name="robots" content="noindex,nofollow">

<title>SquirrelMail - Login</title><script language="JavaScript" type="text/javascript">
<!--
  var alreadyFocused = false;
  function squirrelmail_loginpage_onload() {
    document.login_form.js_autodetect_results.value = '1';
    if (alreadyFocused) return;
    var textElements = 0;
    for (i = 0; i < document.login_form.elements.length; i++) {
      if (document.login_form.elements[i].type == "text" || document.login_form.elements[i].type == "password") {
        textElements++;
        if (textElements == 1) {
          document.login_form.elements[i].focus();
          break;
        }
      }
    }
  }
// -->
</script>

<style type="text/css">
<!--[if IE 6]>
/* avoid stupid IE6 bug with frames and scrollbars */
body {
    width: expression(document.documentElement.clientWidth - 30);
}
<![endif]-->
</style>

</head><body onload="squirrelmail_loginpage_onload();" alink="#0000cc" bgcolor="#ffffff" link="#0000cc" text="#000000" vlink="#0000cc">
<form action="redirect.php" method="post" name="login_form">
<table bgcolor="#ffffff" border="0" cellpadding="0" cellspacing="0" width="100%"><tbody><tr><td align="center"><center><img src="login_files/sm_logo.png" alt="SquirrelMail Logo" height="111" width="308"><br>
<small>SquirrelMail version 1.4.15<br>
  By the SquirrelMail Project Team<br></small>
<table bgcolor="#ffffff" border="0" width="350"><tbody><tr><td align="center" bgcolor="#dcdcdc"><b>SquirrelMail Login</b>
</td>
</tr>
<tr><td align="left" bgcolor="#ffffff">
<table align="center" bgcolor="#ffffff" border="0" width="100%"><tbody><tr><td align="right" width="30%">Name:</td>
<td align="left" width="70%"><input name="login_username" value="" onfocus="alreadyFocused=true;" type="text">
</td>
</tr>

<tr><td align="right" width="30%">Password:</td>
<td align="left" width="70%"><input name="secretkey" onfocus="alreadyFocused=true;" type="password">
<input name="js_autodetect_results" value="1" type="hidden">
<input name="just_logged_in" value="1" type="hidden">
</td>
</tr>
</tbody></table>
</td>
</tr>
<tr><td align="left"><center><input value="Login" type="submit">
</center></td>
</tr>
</tbody></table>
</center></td>
</tr>
</tbody></table>
</form>
</body></html>