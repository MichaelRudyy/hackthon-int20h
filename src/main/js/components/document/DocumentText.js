import React, {Component} from "react";
import Points from "./Points";

export default class DocumentText extends Component {
    constructor(props) {
        super(props);
        this.state = {
            sections: [
                {id: 1, text: 'Ого, такой вот вопросик.', thesis: 'Text of note lorem ipsum blah balh balr\nToo much text'},
                {id: 2, text: 'Прямо садись и рассказывай всю свою жизнь!', thesis: 'Text of note lorem ipsum blah balh balr\nToo much text'},
                {id: 3, text: 'Значит, во-первых (хронологически) — за то, что сообщили мне некоторую веру в себя', thesis: 'Text of note lorem ipsum blah balh balr\nToo much text'},
                {id: 4, text: 'Когда ты начинающий, робкий новичок и тебе авторитетный, искушенный в своем деле мастер говорит, что у тебя получается — это создает неслыханной силы импульс.', thesis: 'Text of note lorem ipsum blah balh balr\nToo much text'},
                {id: 5, text: 'Во-вторых, за среду.', thesis: 'Text of note lorem ipsum blah balh balr\nToo much text'}
            ],
            documentTitle: 'Document 1'
        }
    }

    componentDidMount() {
        document.title = "Text Learner Interface"
        // pull sections from backend
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