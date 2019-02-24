import React, {Component} from "react";
import DocumentStart from "./DocumentStart"
import DocumentText from "./DocumentText"

export default class  Document extends Component {
    constructor(props) {
        super(props);
        this.state = {
            stage: 0
        };
        this.incrementStage = this.incrementStage.bind(this)
    }

    componentDidMount() {
        document.title = "Text Learner Interface"
        // pull sections from backend
    }

    incrementStage() {
        let newStage = this.state.stage + 1;
        this.setState({
            stage: newStage
        });
    }

    render() {
        return (this.state.stage === 0 ? <DocumentStart onStart={this.incrementStage.bind(this)}/> : <DocumentText stage={this.state.stage} onNextStage={this.incrementStage}/>)
    }
}