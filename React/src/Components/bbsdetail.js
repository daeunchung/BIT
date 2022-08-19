import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

import "./bbsdetail.css";

export default function Bbsdetail(){
    const [bbs, setBbs] = useState(0);

    let { seq } = useParams();
    //alert(seq);

    useEffect( () => {
        const fetchData = async (s) => {
            await axios.get("http://localhost:3000/getBbs", { params:{ "seq":s } })
                .then(function(resp){
                   //console.log(resp.data);
                   
                   setBbs(resp.data);
                })
                .catch(function(error){
                    console.log(error);
                })
        }
        fetchData(seq);
    });

    return (
        <div>
            <div id="app" className="container">
            <table className="table table-striped">
            <tbody>
            <tr>
	            <th>작성자</th>
	            <td>{bbs.id}</td>
            </tr>
            <tr>
                <th>작성일</th>
                <td>{bbs.wdate}</td>
            </tr>

            <tr>
                <th>조회수</th>
                <td>{bbs.readcount}</td>	
            </tr>

            <tr>
                <td colSpan="2" className="title">{bbs.title}</td>
            </tr>

            <tr>	
                <td colSpan="2">
                    <pre className="content">
                            {bbs.content}
                    </pre>
                </td>
            </tr>
            </tbody>
            </table>
            </div>
        </div>
    )
}
