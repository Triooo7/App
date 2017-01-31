function Entry(){
    document.getElementById('Entry').style.display='';
    document.getElementById('Exit').style.display='none';
}
function Exit(){
    document.getElementById('Entry').style.display='none';
    document.getElementById('Exit').style.display='';
}
function EmployeeCheck(inputNumber){
    if(inputNumber.length ===0){
        alert('input fields cannot be empty');
        return false;
    }
    var data = {
        personalNumber : inputNumber
    };
    IsEmployee(data,function(test){
       if(test.length!==0){
           data.entryTime = new Date();
            EmployeeEntry(data,function(test1){
                if(test1==1){
                    alert('OK');
                    document.getElementById('Entry').style.display = 'none';
                    document.getElementById('inputPno').value = '';
                    Count();
                }
                else{
                    alert('Employee inside the building');
                    document.getElementById('Entry').style.display = 'none';
                    document.getElementById('inputPno').value = '';
                    Count();
                }
            });
       }
       else{
           alert('Not an Employee Enter name and HostId');
           document.getElementById('onlyVisitor').style.display = 'block';
           document.getElementById('inputPno').value = '';
       }
    });

}

function VisitorLog(name,hostId){
    if(name.length === 0 || hostId.length === 0){
        alert('Input fields cannot be empty');
        return false;
    }

    var data = {
        personalNumber : hostId
    };
    IsEmployee(data,function(test){
       if(test.length!=0){
            var data2 = {
                visitorName:name,
                hostId:hostId,
                entryTime: new Date()
            };
            VisitorEntry(data2,function(test1){
                if(test1==1){
                    alert('Visitor is permitted');
                    document.getElementById('VisitorName').value ='';
                    document.getElementById('hostId').value ='';
                    document.getElementById('onlyVisitor').style.display = 'none';
                    document.getElementById('Entry').style.display = 'none';
                    Count();
                }
                else{
                    alert('visitor already in the building');
                    document.getElementById('VisitorName').value ='';
                    document.getElementById('hostId').value ='';
                    document.getElementById('onlyVisitor').style.display = 'none';
                    document.getElementById('Entry').style.display = 'none';
                    Count();
                }
            });
       }
       else{
           alert('given HostId is not an Employee');
           document.getElementById('VisitorName').value ='';
           document.getElementById('hostId').value ='';
           document.getElementById('onlyVisitor').style.display = 'none';
           document.getElementById('Entry').style.display = 'none';
       }
    });

}

function EmployeeExitHandler(){
    document.getElementById('EmployeeExitDiv').style.display='block';
    document.getElementById('VisitorExitDiv').style.display='none';

}

function VisitorExitHandler(){
    document.getElementById('VisitorExitDiv').style.display='block';
    document.getElementById('EmployeeExitDiv').style.display='none';

}

function VisitorExitLog(name,hostid){
    if(name.length ===0 || hostid.length === 0){
        alert('fields cannot be empty');
        return false;
    }
    var data = {
        visitorName : name,
        hostId : hostid,
        exitTime : new Date()
    };
    VisitorExit(data,function(test){
        if(test == 1){
            alert('Visitor Exit registered');
            document.getElementById('VisitorExitName').value='';
            document.getElementById('VisitorExitHostId').value='';
            document.getElementById('Exit').style.display = 'none';
            document.getElementById('VisitorExitDiv').style.display = 'none';
            Count();


        }
        else{
            alert('Given Details may be Wrong, Please re-enter the details or Visitor may not be in the building');
            document.getElementById('VisitorExitName').value='';
            document.getElementById('VisitorExitHostId').value='';
            document.getElementById('Exit').style.display = 'none';
            document.getElementById('VisitorExitDiv').style.display = 'none';
            Count();
        }
    });


}

function EmployeeExitLog(value){
    if(value.length === 0){
        alert('fields cannot be Empty');
        return false;
    }
    var data = {
        personalNumber : value
    };
    IsEmployee(data,function(test){
        if(test.length !== 0){
            data.exitTime = new Date();
            EmployeeExit(data,function(test1){
                if(test1==0){
                    alert('Employee not in the building');
                    document.getElementById('EmployeeExitPersonalNumber').value='';
                    document.getElementById('Exit').style.display = 'none';
                    document.getElementById('EmployeeExitDiv').style.display = 'none';
                    Count();
                }
                else{
                    alert('Employee exit registered');
                    document.getElementById('EmployeeExitPersonalNumber').value='';
                    document.getElementById('EmployeeExitDiv').style.display = 'none';
                    document.getElementById('Exit').style.display = 'none';
                    Count();
                }
            });
        }
        else{
            alert('Not an Employee. Please Re-enter correct Personal Number or Please select exit option as visitor');
            document.getElementById('EmployeeExitPersonalNumber').value='';
        }
    });



}

function Count(){
    VisitorCount(function(test){
        document.getElementById('VisitorCount').innerHTML = 'number of Visitors : '+test.length ;
    });
    EmployeeCount(function(test){
        document.getElementById('EmployeeCount').innerHTML = 'number of Employees : '+test.length ;
    });

}