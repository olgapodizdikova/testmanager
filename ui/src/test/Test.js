import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import {Button, Col, Container, Row} from "react-bootstrap";
import TestList from "./TestList";

class Test extends Component {

    constructor(props) {
        super(props);
        this.state = {tests: [], statuses: []};
        this.updateStatus = this.updateStatus.bind(this);
    }

    componentDidMount() {
        fetch('/tests')
            .then(response => response.json())
            .then(data => this.setState({tests: data}));
        fetch('/execution-statuses')
            .then(response => response.json())
            .then(data => this.setState({statuses: data}));
    }

    async updateStatus(id, status) {
        await fetch(`/tests/${id}/status`,
            {
                method: 'PATCH',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({status: status})
            }).then((response) => {
                if(response.ok) {
                    this.updateTestStatus(id, status);
                    console.log('status updated');
                } else {
                    console.log('status updating failed');
                }
            });
    }

    updateTestStatus(id, status) {
        let tests = [...this.state.tests];
        let index = tests.findIndex(el => el.id === id);
        tests[index].status = status;
        this.setState({tests});
    }

    render() {
        return (
                <Container fluid>
                    <Row>
                        <Col style={{marginTop: '10px'}}>
                            <Link to="/new">
                                <Button variant="outline-primary">
                                    Create a new test
                                </Button>
                            </Link>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <TestList tests={this.state.tests}
                                      statuses={this.state.statuses}
                                      updateStatus={this.updateStatus}/>
                        </Col>
                    </Row>
                </Container>
        );
    }
}

export default Test;