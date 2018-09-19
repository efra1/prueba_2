
#menuArriba{
  background-color: black;
}

.menu{
       float:left;
     margin-top: 9px;
}
.menu li{
    display:inline-block;
}
 .menu li:first-child{
    margin-left:0;
}
.menu li a{
    display: block;
    font-size:1em;
    color:white;
    -webkit-transition: all 0.3s ease;
    -moz-transition: all 0.3s ease;
    -o-transition: all 0.3s ease;
    transition: all 0.3s ease;
    font-weight: bold;
}
#nav .current a {
   color:#fff;
   background:#6dc5dd;
   -webkit-transition: all 0.3s ease;
    -moz-transition: all 0.3s ease;
    -o-transition: all 0.3s ease;
    transition: all 0.3s ease;
}
.menu li a:hover ,.menu li.active a{
   color:#fff;
   background:#f77462 !important;
} 
.dropdown-menu{
   background:#808080 !important;
   color:white;
}
.toggleMenu {
    display:  none;
    padding:4px 5px 0px 5px;
    border-radius:2em; 
    -webkit-border-radius:2em;
    -moz-border-radius:2em;
    -o-border-radius:2em; 
}
.nav:before,
.nav:after {
    content: " "; 
    display: table; 
}
.nav:after {
    clear: both;
}
.nav ul {
    list-style: none;

}

body{
        background-color: #c0c0c0; 

    }

    
/* -- botones --*/
#uno{

    background-color: #708090;

}
#dos{
    background-color: #800080;
}
#tres{
    background-color:  #FF8C00;
}
#cuatro{
    background-color: #00FF00;
}

#cinco{
    background-color: #008000;
}



a span.badge{
    display: block;
    margin: 20px auto;
    background-color: white;
    color: black;
    width: 20px;
    padding: 20px;
    border-radius: 50%;
}

p.texto{
    font-size: 1.4em;
    color: white;
     
    text-align: center;
    padding-top: 0px;
    opacity: .6;

}
#menuder{
    background-color: white;
    text-align: right;
    color: red;
}
#inicio{
    background-color: #0000ff;
    color: white;
}
#textoNav{
color: #00ffff;
}
  