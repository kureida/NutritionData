<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.kureida.NutritionData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%NutritionData nDP = new NutritionData(); %>
    <link href="resources/dist/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
    <link type="text/css" rel="stylesheet" href="stylesheets/intro.css"/>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="resources/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <script type="text/javascript" src="resources/utils.js"></script>
    <title>Newtrition Data</title>
    <script>
        $(function () {
            $("#lefttabs").tabs();
        });
        $(function () {
            $("#toptabs").tabs();
        });

    </script>
    <script>
        var kindList = [<%=nDP.getKinds()%>]; //returns all kinds
        var foodList = [<%=nDP.getAllFood()%>]; //returns a list of all foods of every kind

    </script>
</head>
<body>
<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();

%>

<div id="toptabs">
    <div id="topcontent">
        <ul>
            <li><a class="glidebutton" href="#tt-1"><span data-text="Home">Home</span></a></li>
            <li><a class="glidebutton" href="#tt-2"><span data-text="Post">Post</span></a></li>

        </ul>
    </div>
    <div id="topleftcontent">
        <div class="btn-group">
            <button type="button" class="btn btn-success" data-toggle="dropdown"
                    style="float:right;margin:5px;"><%=user.getNickname()%> <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="<%=userService.createLogoutURL(request.getRequestURI())%>">Sign Out</a></li>
            </ul>
        </div>
    </div>
    <div id="maincontent">
        <div class="innertube">
            <div id="tt-1">
                <form action="/retrieve" method="get">
                    Recipe Ingredient(s) <br>
                    Ingredient Name: <input type="text" name="foodName0"><br><br>
                    Type (used for faster searches): <select id="typeofFood0" name="typeofFood0">

                    </select>
                    <script>addFoodType()</script>

                    <br>
                    <br>

                    <input type="text" onfocus="inputFocus(this)" name="sSize0" onblur="inputBlur(this)" style="color:#888;" value="Enter Serving Size">
                    <select name="typeofWeight0">
                        <option value="g" >grams</option>
                        <option value="oz">ounces</option>
                    </select>
                    <br>
                    <div id="additionalIngredients"></div>
                    <br>
                    <a class="btn btn-danger" onclick="addIngredient()">Add ingredient to recipe</a>
                    <button type="submit" class="btn btn-primary" value="submit">Fetch Nutrition Values</button>
                </form>
                <!--
                    <li class="bg1">
                        <div class="heading">Heading</div>
                        <div class="bgDescription"></div>
                        <div class="description">
                            <h2>Heading</h2>
                            <p>Some descriptive text</p>
                            <a href="#">more ?</a>
                        </div>
                    </li>
                    <li>
                        <div class="heading">Heading 2</div>
                        <div class="bgDescription"></div>
                        <div class="description">
                            <h2>Heading</h2>
                            <p>Some descriptive text</p>
                            <a href="#">more ?</a>
                        </div>
                    </li>-->
                <ul class="accordion" id="accordion">
                </ul>
            </div>
            <div id="tt-2">
                <div id="tt-2_left_side" style="width:50%; float:left;">
                    <% if (userService.isUserAdmin()) {%>
                    <form action="/post" method="post">
                        <p>Manual Food Store</p>

                        <div class="row">
                            <div class="col-6">
                                Type of Food:
                            </div>
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)"
                                       value="Leave blank if unknown" name="typeofFood0" type="text"
                                       style="color:#888;">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="name0" value="Name"
                                       type="text" style="color:#888;">

                            </div>
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="servingSize0"
                                       value="Serving Size (g)" type="text" style="color:#888;">

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="calories0"
                                       value="Calories" type="text" style="color:#888;">

                            </div>
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="fatCalories0"
                                       value="Fat Calories" type="text" style="color:#888;">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="totalFatGrams0"
                                       value="Total Fat (g)" type="text" style="color:#888;">

                            </div>
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="totalFatPercentage0"
                                       value="Total Fat (%)" type="text" style="color:#888;">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="satFatGrams0"
                                       value="Saturated Fat (g)" type="text" style="color:#888;">

                            </div>
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="satFatPercentage0"
                                       value="Saturated Fat (%)" type="text" style="color:#888;">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="cholesterolMilligrams0"
                                       value="Cholesterol (mg)" type="text" style="color:#888;">
                            </div>
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="cholesterolPercentage0"
                                       value="Cholesterol (%)" type="text" style="color:#888;">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="sodiumMilligrams0"
                                       value="Sodium (mg)" type="text" style="color:#888;">
                            </div>
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="sodiumPercentage0"
                                       value="Sodium (%)" type="text" style="color:#888;">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="totalCarbsGrams0"
                                       value="Total Carbs (g)" type="text" style="color:#888;">
                            </div>
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="totalCarbsPercentage0"
                                       value="Total Carbs (%)" type="text" style="color:#888;">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="fiberGrams0"
                                       value="Fiber (g)" type="text" style="color:#888;">

                            </div>
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="fiberPercentage0"
                                       value="Fiber (%)" type="text" style="color:#888;">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="sugarGrams0"
                                       value="Sugar (g)" type="text" style="color:#888;">

                            </div>
                            <div class="col-6">
                                <input onfocus="inputFocus(this)" onblur="inputBlur(this)" name="proteinGrams0"
                                       value="Protein (g)" type="text" style="color:#888;">
                            </div>
                        </div>
                        <br>

                        <div id="addition"></div>

                        <a class="btn btn-danger" onclick="addFood()">Click to add additional food</a>
                        <button type="submit" class="btn btn-primary" value="submit">Store the data</button>
                    </form>
                    <%} else {%>
                    You must be an admin to post data.
                    <%}%>
                </div>
                <div id="tt-2_right_side" style="width:50%; float:right;">
                    <table id="foodTable" style="width:100%" class="table table-striped">
                        <caption><b>Food within the database</b></caption>
                        <thead>
                        <tr>
                            <th>Type</th>
                            <th>Foods</th>
                        </tr>
                        </thead>

                    </table>
                    <script>sectionFood(kindList, foodList);</script>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>