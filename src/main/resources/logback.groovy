import ch.qos.logback.classic.encoder.PatternLayoutEncoder

import java.nio.charset.Charset

def loggerList = ['STDOUT']


//conversionRule 'clr', ColorConverter
//conversionRule 'wex', WhitespaceThrowableProxyConverter

// See http://logback.qos.ch/manual/groovy.html for details on configuration
appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        charset = Charset.forName('UTF-8')
        pattern = "%d %level %thread %mdc %logger - %m%n"
    }
}

root(ERROR, loggerList)


// set additivity to false to avoid possible double logging caught by root log level
logger('example.springboot', DEBUG, loggerList, false)
// hibernate SQL and bind variable tracking
logger('org.hibernate.SQL', DEBUG, loggerList, false)    // show sql statements
logger('org.hibernate.type.descriptor.sql.BasicBinder', TRACE, loggerList, false)  // show sql bind variable values

logger('org.apache.http.headers', TRACE, loggerList, false)
logger('org.apache.http.wire', DEBUG, loggerList, false)


