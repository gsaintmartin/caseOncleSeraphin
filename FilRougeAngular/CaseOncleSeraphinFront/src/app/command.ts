import { User } from './user';
import { CommandState } from './command-state.enum';
import { CommandLine } from './command-line';
import { LinkedList } from 'ngx-bootstrap/utils/public_api';

export class Command {
  commandReference: number;
  commandDate: Date;
  state: CommandState;
  user: User;
  listCommandLines: LinkedList<CommandLine>;

  constructor(commandDate: Date, state: CommandState) {

 this.commandDate = commandDate;
 this.state = state;
  }
}
