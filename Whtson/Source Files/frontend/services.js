function VisitorExit(data,done){
    var xhr = new XMLHttpRequest();
    xhr.open('PUT', '/api/visitorLog');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.setRequestHeader('Accept','application/json');
    xhr.responseType = 'json';
    xhr.onload = function() {
         done(xhr.response);
    };
    xhr.send(JSON.stringify(data));

}

function VisitorEntry(data,done){
    var xhr = new XMLHttpRequest();
    xhr.open('POST','/api/visitorLog');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.setRequestHeader('Accept','application/json');
    xhr.responseType = 'json';
    xhr.onload = function(){
        done(xhr.response);
    };
    xhr.send(JSON.stringify(data));
}


function VisitorCount(done){
    var xhr = new XMLHttpRequest();
    xhr.open('GET','/api/visitorLog');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.setRequestHeader('Accept','application/json');
    xhr.responseType = 'json';
    xhr.onload = function(){
        done(xhr.response);
    };
    xhr.send();
}

function EmployeeExit(data,done){
    var xhr = new XMLHttpRequest();
    xhr.open('PUT', '/api/employeeLog');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.setRequestHeader('Accept','application/json');
    xhr.responseType = 'json';
    xhr.onload = function() {
        done(xhr.response);
    };
    xhr.send(JSON.stringify(data));

}

function EmployeeEntry(data,done){
    var xhr = new XMLHttpRequest();
    xhr.open('POST','/api/employeeLog');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.setRequestHeader('Accept','application/json');
    xhr.responseType = 'json';
    xhr.onload = function(){
        done(xhr.response);
    };
    xhr.send(JSON.stringify(data));
}


function EmployeeCount(done){
    var xhr = new XMLHttpRequest();
    xhr.open('GET','/api/employeeLog');
    xhr.setRequestHeader('Accept','application/json');
    xhr.responseType = 'json';
    xhr.onload = function(){
        done(xhr.response);
    };
    xhr.send();
}

function IsEmployee(data,done){
    var xhr = new XMLHttpRequest();
    xhr.open('POST','/api/employee');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.setRequestHeader('Accept','application/json');
    xhr.responseType = 'json';
    xhr.onload = function(){
        done(xhr.response);
    };
    xhr.send(JSON.stringify(data));
}

