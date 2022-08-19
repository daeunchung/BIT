import React, {useEffect, useState} from "react";

import axios from "axios";

function App() {

  const [memList, setMemList] = useState([]);

  useEffect(()=>{
    /*
    const fetchData = async () => {
      const response = await axios.get('http://localhost:3000/base', {})
      console.log(response.data);
    }
    */

    /*
    const fetchData = async () => {
      const response = await axios.get('http://localhost:3000/member', {})
      console.log(response.data);
      console.log(response.data.id);
    }
    */

    /*
    const fetchData = async () => {
      const response = await axios.get('http://localhost:3000/conn_param', 
                                    { params:{ "title":"제목입니다", "num":248 } })
      console.log(response.data);
    }
    */

    /*
    const fetchData = async () => {
      const response = await axios.post('http://localhost:3000/conn_param_obj', null,
                                    { params:{ "id":"abc123", "pwd":"xyz789" } })
      console.log(response.data);
    }
    */

    /*
    const fetchData = async () => {
      const response = await axios.get('http://localhost:3000/db_test', {})
      console.log(response.data);
    }
    */

    const fetchData = async () => {
      await axios.get('http://localhost:3000/db_test', {})
          .then(function(resp){ // 성공! == success
            // console.log(resp.data); 
            // console.log(resp.data[0].id);
            setMemList(resp.data);
          })
          .catch(function(error){
            alert('error');
          })
      
    }

    fetchData();

  });


  return (
    <div>

      <table border="1">
        <thead>
      <tr>
        <th>num</th>  
        <th>id</th>  
        <th>pw</th>  
        <th>name</th>  
        <th>email</th>  
      </tr> 
      </thead>
      <tbody>
      {
        memList.map(function(obj, i){     // == $.each(list, function(item, index))
          return (
            // <tr>
            //   <th>{i + 1}</th>
            //   <td>{obj.id}</td>
            //   <td>{obj.pwd}</td>
            //   <td>{obj.name}</td>
            //   <td>{obj.email}</td>
            // </tr>
            <TableRow obj={obj} key={i} cnt={i + 1}/>
          )  
        })
      }
      </tbody>
      </table>

      
    </div>
  );
}

function TableRow(props){
  return (
    <tr>
      <th>{props.cnt}</th>
      <td>{props.obj.id}</td>
      <td>{props.obj.pwd}</td>
      <td>{props.obj.name}</td>
      <td>{props.obj.email}</td>
    </tr>
  );
}

export default App;
