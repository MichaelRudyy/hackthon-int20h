import React, {Component} from "react";
import axios from "axios";
import Points from './Points';

export default class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            sections: [
                {id: 1, text: 'Ого, такой вот вопросик.', thesis: 'Text of note lorem ipsum blah balh balr<br/>Too much text'},
                {id: 2, text: 'Прямо садись и рассказывай всю свою жизнь!', thesis: 'Text of note lorem ipsum blah balh balr<br/>Too much text'},
                {id: 3, text: 'Значит, во-первых (хронологически) — за то, что сообщили мне некоторую веру в себя', thesis: 'Text of note lorem ipsum blah balh balr<br/>Too much text'},
                {id: 4, text: 'Когда ты начинающий, робкий новичок и тебе авторитетный, искушенный в своем деле мастер говорит, что у тебя получается — это создает неслыханной силы импульс.', thesis: 'Text of note lorem ipsum blah balh balr<br/>Too much text'},
                {id: 5, text: 'Во-вторых, за среду.', thesis: 'Text of note lorem ipsum blah balh balr<br/>Too much text'}
            ],
            documentTitle: 'Document 1'
        }
    }

    componentDidMount() {
        // pull sections from backend
    }

    render() {
        return (
            <div>
                <div className="container-fluid">
                    <div id="tl-header">
                        {this.state.documentTitle}
                    </div>
                    <div className="d-table tl-blurred" id="tl-container">
                        {this.state.sections.map((item, i) => {
                            return (<div className="d-table-row" key={i}>
                                <div className="d-table-cell tl-text" dangerouslySetInnerHTML={{__html: item.text.trim() + "."}}/>
                                <div className="d-table-cell tl-note" dangerouslySetInnerHTML={{__html: item.thesis.trim()}}/>
                            </div>);
                        })}
                    </div>
                </div>
                <Points/>
            </div>
        );
    }
}