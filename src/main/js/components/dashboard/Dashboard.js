import React, {Component} from "react";
import axios from "axios";

export default class Dashboard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            documents: [],
            title: 'Speechify'
        }
        this.toDocument = this.toDocument.bind(this)
        this.componentDidMount = this.componentDidMount.bind(this)
    }

    componentDidMount() {
        document.title = "Text Learner Dashboard"
        console.log(this.props.match.id);
        axios.get('http://localhost:8080/api/documents/byUserEmail', {
            params: {
                email: 'mcrudyy@gmail.com'
            }
        })
            .then(response => {
                console.log(response.data)
                let documents = []
                response.data.map(document => {
                    documents.push({
                            id: document.id,
                            title: document.title,
                            preview: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                            date: document.modificationAt,
                            sections: document.sectionHrefs}
                        )
                })
                console.log(documents)
                this.setState({
                    documents: documents
                })
            })
            .catch(error => {
                console.log(error);
            });
    }

    toDocument(id) {
        return () => this.props.history.push("/document/" + id);
    }

    render() {
        return (
            <div className="container-fluid" id="tld-container-wrap">
                <div id="tl-header">
                    <div className="merriweather">Speechify</div>
                </div>
                <div id="tld-container">
                    <div id="tld-list">
                        {this.state.documents.map((item, i) => {
                            return (
                                <div className="tld-doc float-left" key={i} onClick={this.toDocument(item.id)}>
                                    <div className="tld-thumb">
                                        <div className="thumb-text" dangerouslySetInnerHTML={{__html: item.preview.trim()}} />
                                    </div>
                                    <div className="tld-doc-title" dangerouslySetInnerHTML={{__html: item.title.trim()}}/>
                                    <div className="tld-doc-date" dangerouslySetInnerHTML={{__html: item.date.trim()}}/>
                                </div>
                            )
                        })}
                    </div>
                </div>
            </div>
        )
    }
}