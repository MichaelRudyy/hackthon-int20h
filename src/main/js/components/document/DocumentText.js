import React, {Component} from "react";
import Points from "./Points";
import axios from "axios";

export default class DocumentText extends Component {
    constructor(props) {
        super(props);
        this.state = {
            documentTitle: "Section 1",
            sections: []
        };
    }

    componentDidMount() {
        document.title = 'DocumentText';
        let sections = [];
        console.log(this.props);
        axios.get("http://localhost:8080" + this.props.section.href).then(response => {
            let sents = [];
            console.log(response.data);
            for (var i = 0; i < response.data.sentences.length; i++) {
                let data = response.data.sentences[i];
                sents.push({
                    id: data.number,
                    text: data.text,
                    thesis: data.thesis.text
                });
            }
            this.setState({
                sections: sents
            });
        });
        /*this.props.section.map(sectionItem => {
            axios.get('http://localhost:8080'+item.href, {
                params: {}
            })
                .then(response => {
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

    render() {
        return (
            <div>
                <div className="container-fluid">
                    <div id="tl-header">
                        {this.state.documentTitle}
                    </div>
                    <div className={"d-table " + this.getBlurred()} id="tl-container">
                        {this.state.sections.map((item, i) => {
                            return (
                                <div className="d-table-row" key={i}>
                                    <div className="d-table-cell tl-text" dangerouslySetInnerHTML={{ __html: this.getSoundIcons() + this.getBluerredText(item.text.trim()) + "."}}></div>
                                        {this.getNoteRenderElement(item)}
                                </div>);
                        })}
                    </div>
                </div>
                <Points stage={this.props.stage} onNextStage={this.props.onNextStage}/>
            </div>
        )
    }

    getNoteRenderElement(item) {
        if (this.props.stage === 1) {
            return (
                <div className="d-table-cell tl-note">
                    <textarea className="tl-note-content form-control"
                          placeholder="Add note...">{item.thesis.trim()}</textarea>
                </div>
            );
        } else {
            const thesis = item.thesis.trim().replace(/\n/g, "<br/>");
            return (
                <div className="d-table-cell tl-note" dangerouslySetInnerHTML={{ __html: thesis }}/>
            );
        }
    }

    getSoundIcons() {
        if (this.props.stage === 2) {
            return '<div class="float-right tl-sound"></div><div class="float-right tl-microphone"></div>';
        } else {
            return '';
        }
    }

    getBluerredText(text) {
        if (this.props.stage === 3) {
            const words = text.split(" ");
            for (var i = 2; i < words.length; i += 3) {
                words[i] = '<span class="tl-blurred">' + words[i] + '</span>';
            }
            return words.join(" ");
        } else {
            return text;
        }
    }

    getBlurred() {
        if (this.props.stage === 4) {
            return "tl-blurred";
        } else {
            return "";
        }
    }
}