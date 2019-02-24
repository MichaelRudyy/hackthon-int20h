import React, {Component} from "react";
import DocumentStart from "./DocumentStart"
import DocumentText from "./DocumentText"
import DocumentFinish from "./DocumentFinish"

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
        if (this.state.stage === 0) {
            return <DocumentStart onStart={this.incrementStage.bind(this)}/>
        }
        else if (this.state.stage === 6) {
            return <DocumentFinish/>
        }
        else {
            return <DocumentText stage={this.state.stage} onNextStage={this.incrementStage}/>
        }
    }
}