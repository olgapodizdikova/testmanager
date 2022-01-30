import {Form} from "react-bootstrap";
import React from "react";

export default function StatusSelect({id, value, statuses, updateStatus}) {

    const statusesList = statuses.map(status => {
        return <option key={status.id} value={status.id}>{status.name}</option>
    });

    return (
        <Form.Select aria-label="Test status"
                     value={value || ""}
                     onChange={(value) => updateStatus(id, value.target.value)}>
            <option hidden>Undefined</option>
            {statusesList}
        </Form.Select>
    );
}