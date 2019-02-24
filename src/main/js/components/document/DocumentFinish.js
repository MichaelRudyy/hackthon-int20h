import React, {Component} from "react";
import axios from "axios";

export default class DocumentFinish extends Component {
    constructor(props) {
        super(props);
        this.state = {
            header: 'М. Е. Вадимовна "Одно чудо на всю жизнь"'
        }
        this.toDocuments = this.toDocuments.bind(this)
    }

    componentDidMount() {
        document.title = "Finish Learn Page"
        // pull sections from backend
    }

    toDocuments() {
        location.href = "/"
    }

    render() {
        return (
            <div className="container-fluid" id="tld-container-wrap">
                <div id="tl-header">
                    {this.state.header}
                </div>
                <div id="tlf-container">
                    <div className="tlf-title">Section 3 done!</div>
                    <div className="tlf-finish-wrap">
                        <button className="tlf-finish-btn" onClick={this.toDocuments}>&laquo; Back to documents</button>
                    </div>
                </div>
            </div>
        )
    }
}