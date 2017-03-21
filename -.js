<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <style>
  table{border:0px;width:100%}
  tr{background-color:#0D47A1}
  td{width:20%;text-align:center;color: #FFD54F}
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script>
 
var response = '[{"name":"9", "age":"33", "email":"sadasdsa" }';
response += ',{"name":"6","age":"22","email":"dsadsad"}]';
response = JSON.parse(response);
$(document).ready(function(){
    $.each(response, function (i, item) {
        $('<tr>').append(
        $('<td>').text(item.name),
        $('<td>').text(item.age),
        $('<td>').text(item.email)).appendTo('#records_table');
        //alert(this.id);
        // $('#records_table').append($tr);
        //console.log($tr.wrap('<p>').html());
    });
$.ajax({
    url: 'http://localHost:8090/MentoringServer/MentoringServices/getListMentorProfile',
    dataType: 'json',
    type: 'GET',
    cache: false,
    success: function(data){
            //body reference 
            var body = document.getElementsByTagName("div")[1];
            // create elements <table> and a <tbody>
            var tbl     = document.createElement("table");
            var tblBody = document.createElement("tbody");
            var row = document.createElement("tr");
            
            ///mneteee
          var cell = document.createElement("td");    
          var cellText = document.createTextNode("First Name");            
          cell.appendChild(cellText);
          row.appendChild(cell);
          var cell = document.createElement("td");    
          var cellText = document.createTextNode("Last Name");            
      	  cell.appendChild(cellText);
          row.appendChild(cell);
          var cell = document.createElement("td");    
          var cellText = document.createTextNode("Phone");            
          cell.appendChild(cellText);
          row.appendChild(cell);
          	var cell = document.createElement("td");    
          var cellText = document.createTextNode("Email");            
          cell.appendChild(cellText);
          row.appendChild(cell);
          tblBody.appendChild(row);
          
          /////mentor
          var cell = document.createElement("td");    
          var cellText = document.createTextNode("First Name");            
          cell.appendChild(cellText);
          row.appendChild(cell);
          var cell = document.createElement("td");    
          var cellText = document.createTextNode("Last Name");            
      	  cell.appendChild(cellText);
          row.appendChild(cell);
          var cell = document.createElement("td");    
          var cellText = document.createTextNode("Phone");            
          cell.appendChild(cellText);
          row.appendChild(cell);
          	var cell = document.createElement("td");    
          var cellText = document.createTextNode("Email");            
          cell.appendChild(cellText);
          row.appendChild(cell);
          tblBody.appendChild(row);
          ///start date
          var cell = document.createElement("td");    
          var cellText = document.createTextNode("Start Date");             
        cell.appendChild(cellText);
        row.appendChild(cell);
        
        ///// end date
         var cell = document.createElement("td");    
            var cellText = document.createTextNode("End Date");             
          cell.appendChild(cellText);
          row.appendChild(cell);
      	    
          
          ///is active
           var cell = document.createElement("td");    
            var cellText = document.createTextNode("Is Active");             
          cell.appendChild(cellText);
          row.appendChild(cell);
            
            
            
            // cells creation
            alert(data.length)
            for( k=0;k<data.length;k++) {
                var row = document.createElement("tr");           
                // table row creation
                    // create element <td> and text node 
                    //Make text node the contents of <td> element
                    // put <td> at end of the table row
                    //SELECT mentor.USERID,users.LASTNAME,users.FIRSTNAME,users.PHONE,FROM users INNER JOIN mentor as 'mentorjoin' ON mentor.ID=users.CustomerID INNER JOIN mentor_mentee as 'mentorjoin' ON menteejoin.ID=mentor_mentee.ID ORDER BY mentor.USERID,users.LASTNAME,users.FIRSTNAME,users.PHONE;
                  
                 
                 
                 /////menteee
                  var cell = document.createElement("td");  
                      var cellText = document.createTextNode(data[k].fname);            
                    cell.appendChild(cellText);
                    row.appendChild(cell);
               
                      var cell = document.createElement("td");    
                      var cellText = document.createTextNode(data[k].lname);              
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    
                    var cell = document.createElement("td");    
                      var cellText = document.createTextNode(data[k].phone);              
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    
                    var cell = document.createElement("td");    
                      var cellText = document.createTextNode(data[k].email);             
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    
                /////mentor
                 var cell = document.createElement("td");  
                    var cellText = document.createTextNode(data[k].fname);            
                  cell.appendChild(cellText);
                  row.appendChild(cell);
             
                    var cell = document.createElement("td");    
                    var cellText = document.createTextNode(data[k].lname);              
                  cell.appendChild(cellText);
                  row.appendChild(cell);
                  
                  var cell = document.createElement("td");    
                    var cellText = document.createTextNode(data[k].phone);              
                  cell.appendChild(cellText);
                  row.appendChild(cell);
                  
                  var cell = document.createElement("td");    
                    var cellText = document.createTextNode(data[k].email);             
                  cell.appendChild(cellText);
                  row.appendChild(cell);
              	    
                  ///start date
                  var cell = document.createElement("td");    
                  var cellText = document.createTextNode(data[k].email);             
                cell.appendChild(cellText);
                row.appendChild(cell);
                
                ///// end date
                 var cell = document.createElement("td");    
                    var cellText = document.createTextNode(data[k].email);             
                  cell.appendChild(cellText);
                  row.appendChild(cell);
              	    
           
                  
                  ///is active
                   var cell = document.createElement("td");    
                    var cellText = document.createTextNode(data[k].email);             
                  cell.appendChild(cellText);
                  row.appendChild(cell);
                  
                  //button disconnect
                 // if(data.endDate==null)
                  var btn = document.createElement("BUTTON");        // Create a <button> element
                  var t = document.createTextNode("Disconnect");       // Create a text node
                  btn.appendChild(t);
                  row.appendChild(btn);;
                  

                //row added to end of table body
                tblBody.appendChild(row);
            }
            // append the <tbody> inside the <table>
            tbl.appendChild(tblBody);
            // put <table> in the <body>
            body.appendChild(tbl);
            // tbl border attribute to 
            tbl.setAttribute("border", "2");
        
//      for( k in data){
//          alert(data[k].UserId);
//      }

    }
});
});
</script>




 <script>
///////////////////////////////////////// 
/* var response = '[{"name":"9", "age":"33", "email":"sadasdsa" }';
response += ',{"name":"6","age":"22","email":"dsadsad"}]';
response = JSON.parse(response);
$(document).ready(function(){
    $.each(response, function (i, item) {
        $('<tr>').append(
        $('<td>').text(item.name),
        $('<td>').text(item.age),
        $('<td>').text(item.email)).appendTo('#records_table');
        //alert(this.id);
        // $('#records_table').append($tr);
        //console.log($tr.wrap('<p>').html());
    }); */
$.ajax({
    url: 'http://localHost:8090/MentoringServer/MentoringServices/getListMentorProfile',
    dataType: 'json',
    type: 'GET',
    cache: false,
    success: function(data){
            //body reference 
            var body = document.getElementsByTagName("div")[1];
            // create elements <table> and a <tbody>
            var tbl     = document.createElement("table");
            var tblBody = document.createElement("tbody");
            var row = document.createElement("tr");
            
            ///mneteee
          var cell = document.createElement("td");    
          var cellText = document.createTextNode("First Name");            
          cell.appendChild(cellText);
          row.appendChild(cell);
          var cell = document.createElement("td");    
          var cellText = document.createTextNode("Last Name");            
      	  cell.appendChild(cellText);
          row.appendChild(cell);
          var cell = document.createElement("td");    
          var cellText = document.createTextNode("Phone");            
          cell.appendChild(cellText);
          row.appendChild(cell);
          	var cell = document.createElement("td");    
          var cellText = document.createTextNode("Email");            
          cell.appendChild(cellText);
          row.appendChild(cell);
          tblBody.appendChild(row);

            
            // cells creation
            alert(data.length)
            for( k=0;k<data.length;k++) {
                var row = document.createElement("tr");           
                // table row creation
                    // create element <td> and text node 
                    //Make text node the contents of <td> element
                    // put <td> at end of the table row
                    //SELECT mentor.USERID,users.LASTNAME,users.FIRSTNAME,users.PHONE,FROM users INNER JOIN mentor as 'mentorjoin' ON mentor.ID=users.CustomerID INNER JOIN mentor_mentee as 'mentorjoin' ON menteejoin.ID=mentor_mentee.ID ORDER BY mentor.USERID,users.LASTNAME,users.FIRSTNAME,users.PHONE;
                  
                 
                 
                 /////menteee
                  var cell = document.createElement("td");  
                      var cellText = document.createTextNode(data[k].fname);            
                    cell.appendChild(cellText);
                    row.appendChild(cell);
               
                      var cell = document.createElement("td");    
                      var cellText = document.createTextNode(data[k].lname);              
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    
                    var cell = document.createElement("td");    
                      var cellText = document.createTextNode(data[k].phone);              
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    
                    var cell = document.createElement("td");    
                      var cellText = document.createTextNode(data[k].email);             
                    cell.appendChild(cellText);
                    row.appendChild(cell);
                    
             
                  
                  
                  //button connect
                 // if(data.endDate==null)
                  var btn = document.createElement("BUTTON");        // Create a <button> element
                  var t = document.createTextNode("connect");       // Create a text node
                  var f= document.createElement("form");
                  f.name='myForm';
                  f.method='POST';
                 // f.action='http://localHost:8090/MentoringServer/MentoringServices/getListMentorProfile';
                  btn.appendChild(t);
                  row.appendChild(btn);
       
                  /////mentor
    $.ajax({
    url: 'http://localHost:8090/MentoringServer/MentoringServices/getListMentorProfile',
    dataType: 'json',
    type: 'GET',
    cache: false,
    success: function(data1){
    	alert(data1.length);'
    	/* for(int i=0; i<data1.length;i++)
    		{
    		alert(data1[i].UserId);
    		} */
    }
  });            
			
					  
                  
                  

                //row added to end of table body
                tblBody.appendChild(row);
            }
            // append the <tbody> inside the <table>
            tbl.appendChild(tblBody);
            // put <table> in the <body>
            body.appendChild(tbl);
            // tbl border attribute to 
            tbl.setAttribute("border", "2");
        
//      for( k in data){
//          alert(data[k].UserId);
//      }

    }
});
});
</script>
</head>
<body style="padding-top:100px">
<select>
<!--   <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="mercedes">Mercedes</option>
  <option value="audi">Audi</option> -->
</select>




<div style="width: 100%;height: 100%;background-color: #00ACC1">

<!-- <div style="float:left;width:100%"> -->
<div style="margin:auto;width:100%;height:100%; padding:2%;background-color:#00ACC1;border-radius:5px">
<!-- <table id="records_table" border='1'> -->
<!--     <tr> -->
<!--         <th>name</th> -->
<!--         <th>age</th> -->
<!--         <th>email</th> -->
<!--     </tr> -->
<!-- </table> -->
</div>
</div>
</body>
</html>