import {Col, Row, Table} from "react-bootstrap";
import React from "react";
import StatusSelect from "../component/StatusSelect";

export default function TestList({tests, statuses, updateStatus}) {

    const testList = tests.map(test => {
        const status = test.status
        return <tr key={test.id}>
            <td>
                <Row>
                    <Col xs={12} md={6} style={{whiteSpace: 'nowrap', wordBreak: 'break-word'}}>
                        {test.name}
                    </Col>
                    <Col xs={12} md={6}>
                        <StatusSelect id={test.id}
                                      value={status}
                                      statuses={statuses}
                                      updateStatus={updateStatus}/>
                    </Col>
                </Row>
            </td>
        </tr>
    });

    return (
        <Table borderless>
            <tbody>
            {testList}
            </tbody>
        </Table>
    );
}