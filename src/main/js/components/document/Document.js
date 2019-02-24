import React, {Component} from "react";
import DocumentStart from "./DocumentStart"
import DocumentText from "./DocumentText"
import DocumentFinish from "./DocumentFinish"
import axios from "axios";

export default class  Document extends Component {
    constructor(props) {
        super(props);
        this.state = {
            stage: 0,
            sections: []
        };
        this.incrementStage = this.incrementStage.bind(this)
    }

    componentDidMount() {
        document.title = "Text Learner Interface"
        // pull sections from backend


        axios.get('http://localhost:8080/api/documents/byUserEmail', {
            params: {
                email: 'mcrudyy@gmail.com'
            }
        }).then(response => {
            let curObj;
            for (let i = 0; i < response.data.length; i++) {
                if (response.data[i].id === this.props.match.params.id) {
                    curObj = response.data[i];
                    break;
                }
            }
            let sect;
            for (let i = 0; i < curObj.sectionHrefs.length; i++) {
                if (curObj.sectionHrefs[i].status === "ACTIVE") {
                    sect = curObj.sectionHrefs[i];
                    break;
                }
            }
            this.setState({
                section: sect
            })
        })
        let sections = []
        // axios.get("http://localhost:8080/api/section/" + this.props.match.params.id).then(response => {
        //     console.log(response);
        // });
        /*this.props.sections.map(sectionItem => {
            axios.get('http://localhost:8080'+item.href, {
                params: {}
            })
                .then(response => {
                    console.log(response);
                    let text = ""
                    let thesis = ""
                    response.data.sectionItem.sentences.map(sentenceItem => {
                        text += sentenceItem.text+' '
                        thesis += sentenceItem.thesis.text
                    })
                    sections.push({
                        id: response.data.id,
                        text: text,
                        thesis: thesis
                    })
                    this.setState({
                        sections: sections,
                        documentTitle: this.props.documentTitle
                    })
                })
                .catch(error => {
                    console.log(error);
                });
        })*/

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
            return <DocumentText stage={this.state.stage} onNextStage={this.incrementStage} section={this.state.section}/>
        }
    }
}