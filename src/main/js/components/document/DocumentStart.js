import React, {Component} from "react";
import axios from "axios";

export default class DocumentStart extends Component {
    constructor(props) {
        super(props);
        this.state = {
            header: 'М. Е. Вадимовна "Одно чудо на всю жизнь"',
            section: 'Ого, такой вот вопросик. Прямо садись и рассказывай всю свою жизнь! Значит, во-первых (хронологически) — за то, что сообщили мне некоторую веру в себя. Когда ты начинающий, робкий новичок и тебе авторитетный, искушенный в своем деле мастер говорит, что у тебя получается — это создает неслыханной силы импульс. Во-вторых, за среду. Эльга Львовна вовсю приобщала нас к среде взрослых, профессиональных переводчиков, да и нас самих, неофитов, превращала в группу единомышленников, поглощенных общим делом и вообще литературой. ',
        }
    }

    componentDidMount() {
        document.title = "Starting Learn Page"
        // pull sections from backend
    }

    render() {
        return (
            <div className="container-fluid" id="tld-container-wrap">
                <div id="tl-header">
                    {this.state.header}
                </div>
                <div id="tls-container">
                    <div className="tls-title">Let's try to learn the next section</div>
                    <div className="tls-section">
                        {this.state.section}
                    </div>
                    <div className="tls-start-wrap">
                        <button className="tls-start-btn" onClick={this.props.onStart}>Start &raquo;</button>
                    </div>
                </div>
            </div>
        )
    }
}