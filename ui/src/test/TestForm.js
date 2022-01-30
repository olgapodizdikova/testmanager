import {Link, withRouter} from "react-router-dom";
import React, {Component} from "react";
import {Button, Container, Form} from "react-bootstrap";

class TestForm extends Component {

    newTest = {
        name: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            test: this.newTest
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let test = {...this.state.test};
        test[name] = value;
        this.setState({test});
    }

    async handleSubmit(event) {
        event.preventDefault();
        await fetch('/tests', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(this.state.test),
        }).then((response) => {
            if (response.ok) {
                console.log('new test created');
                this.props.history.push('/');
            } else {
                console.log('test creation failed');
            }
        });
    }

    render() {
        return <Container fluid>
            <h4>Create Test</h4>
            <Form onSubmit={this.handleSubmit}>
                <Form.Group>
                    <Form.Label>Test name</Form.Label>
                    <Form.Control required type="text"
                                  name="name"
                                  onChange={this.handleChange}/>
                </Form.Group>
                <Form.Group style={{marginTop: '10px'}}>
                    <Button variant="outline-primary"
                            type="submit"
                            style={{marginRight: '10px'}}>
                        Save
                    </Button>
                    <Link to="/">
                        <Button variant="outline-secondary">Cancel</Button>
                    </Link>
                </Form.Group>
            </Form>
        </Container>
    }
}

export default withRouter(TestForm);